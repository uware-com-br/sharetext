package br.com.uware.share

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnShare.setOnClickListener {
            val shareTask = etShare.text.toString()
            val dialog = AlertDialog.Builder(this).setTitle("Info").setMessage("Você deseja compartilhar?")
                .setPositiveButton("Sim") { dialog, _ ->
                    setShareIntent(shareTask(shareTask))
                    dialog.dismiss()
                }
                .setNegativeButton("Não") { dialog, _ ->
                    dialog.dismiss()
                }
            dialog.show()
        }
    }
    private fun setShareIntent(shareBody: String){
        val sharingIntent = Intent(Intent.ACTION_SEND)
        sharingIntent.type = "text/plain"
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody)
        startActivity(Intent.createChooser(sharingIntent, "Share text da https://uware.com.br"))
    }
    fun shareTask(str: String): String {
        val resp = "Share Text:\n"+str+"\nhttps://uware.com.br"
        return resp
    }
}
