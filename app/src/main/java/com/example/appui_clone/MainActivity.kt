package com.example.appui_clone





import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.OnBackPressedCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import com.example.appui_clone.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import de.hdodenhof.circleimageview.CircleImageView
import java.io.FileNotFoundException
import java.io.IOException


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var homeFragment: HomeFragment
    private lateinit var esportsFragment: EsportsFragment
    private lateinit var loungeFragment: LoungeFragment
    private lateinit var originalFragment: OriginalFragment
    private lateinit var notiFragment: NotiFragment
    private lateinit var profileFragment: ProfileFragment
    private lateinit var drawerLayout: DrawerLayout

    private lateinit var appBarConfiguration: AppBarConfiguration
    private var nav: NavigationView? = null

    lateinit var ivProfile: CircleImageView
    lateinit var resultLauncher: ActivityResultLauncher<Intent>

    companion object {
        const val TAG: String = "로그"
    }

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val bottomNavi: BottomNavigationView by lazy {
        binding.bottomNavi
    }

    private val callbackTwo = object : OnBackPressedCallback(
        true
    ) {
        override fun handleOnBackPressed() {
            Log.d(TAG, "handleOnBackPressed: Two")
        }
    }

    private val callbackThree = object :OnBackPressedCallback(
        true
    ) {
        override fun handleOnBackPressed() {
            Log.d(TAG, "handleOnBackPressed: Three")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        this.onBackPressedDispatcher.addCallback(this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    Log.d(TAG, "handleOnBackPressed: One")
                }
            })
        this.onBackPressedDispatcher.addCallback(this,
            callbackTwo)
        this.onBackPressedDispatcher.addCallback(this,
            callbackThree)

        callbackThree.isEnabled = false

        supportFragmentManager.beginTransaction().add(R.id.framelayout, HomeFragment()).commit()

        val profileImage = findViewById<ImageButton>(R.id.iv_profile)
        val myPageImage = findViewById<CircleImageView>(R.id.circleImageView)



//        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_OPEN)
//        drawerLayout.openDrawer(Gravity.LEFT)
//        binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)

//        profileImage.setOnClickListener(View.OnClickListener() {
//            binding.drawerLayout.closeDrawer(GravityCompat.END)
//        })

        bottomNavi.setOnItemSelectedListener {
//            if (it.itemId == R.id.menu_home) supportFragmentManager.beginTransaction().replace(R.id.framelayout, homeFragment).commit()
            when(it.itemId) {
                R.id.menu_home -> {
                    Log.d(TAG, "onNavigationItemSelected: 홈버튼 클릭")
                    homeFragment = HomeFragment.newInstance()
                    supportFragmentManager.beginTransaction().replace(R.id.framelayout, homeFragment).commit()
                }
                R.id.menu_esports -> {
                    Log.d(TAG, "onNavigationItemSelected: 검색버튼 클릭")
                    esportsFragment = EsportsFragment.newInstance()
                    supportFragmentManager.beginTransaction().replace(R.id.framelayout, esportsFragment).commit()
                }
                R.id.menu_lounge -> {
                    Log.d(TAG, "onNavigationItemSelected: 카테고리 클릭")
                    loungeFragment = LoungeFragment.newInstance()
                    supportFragmentManager.beginTransaction().replace(R.id.framelayout, loungeFragment).commit()
                }
                R.id.menu_original -> {
                    Log.d(TAG, "onNavigationItemSelected: 마이페이지 클릭")
                    originalFragment = OriginalFragment.newInstance()
                    supportFragmentManager.beginTransaction().replace(R.id.framelayout, originalFragment).commit()
                }
                R.id.menu_noti -> {
                    Log.d(TAG, "onNavigationItemSelected: 장바구니 클릭")
                    notiFragment = NotiFragment.newInstance()
                    supportFragmentManager.beginTransaction().replace(R.id.framelayout, notiFragment).commit()
                }
            }
            true
        }

        nav = findViewById(R.id.nav_view);

        binding.navView.setOnClickListener {
            toggleDrawerLayout(binding.root)
        }

        binding.navView.setNavigationItemSelectedListener(this)

        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    var imageUri = result.getData()!!.getData()
                    try {
                        val bitmap = MediaStore.Images.Media.getBitmap(
                            contentResolver, imageUri
                        )
                        ivProfile.setImageBitmap(bitmap) //이미지를 띄울 이미지뷰 설정
                    } catch (e: FileNotFoundException) {
                        e.printStackTrace()
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }

                }
            }

//        setContentView(R.layout.activity_main)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        Log.d(TAG, "onNavigationItemSelected: ${item.title}")
        when(item.itemId) {
            R.id.nav_channel -> {
                intent = Intent(this, ChannelActivity::class.java)
//                startActivity(intent)
                intent.setAction(Intent.ACTION_GET_CONTENT)
                resultLauncher.launch(intent)
            }
        }
        return true
    }

    private fun toggleDrawerLayout(drawerLayout: DrawerLayout) {

        if(!drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.openDrawer(GravityCompat.START)
        }
        else {
            drawerLayout.closeDrawer(GravityCompat.START)
        }
    }




}