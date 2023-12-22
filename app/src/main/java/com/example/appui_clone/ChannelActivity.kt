package com.example.appui_clone

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import de.hdodenhof.circleimageview.CircleImageView
import java.io.FileNotFoundException
import java.io.IOException


class ChannelActivity : AppCompatActivity() {

    lateinit var ivProfile: CircleImageView
    lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_channel)


        val PERMISSION_Album = 101 // 앨범 권한 처리

        // 앨범 버튼 클릭 리스너 구현
        ivProfile = findViewById<CircleImageView>(R.id.myImage)
        ivProfile.setOnClickListener {
            val intent = Intent()
            intent.setType("image/*")
            intent.setAction(Intent.ACTION_GET_CONTENT)
            resultLauncher.launch(intent)
        }

        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                    result ->
                if (result.resultCode == RESULT_OK && result.getData() != null) {
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


    }




}