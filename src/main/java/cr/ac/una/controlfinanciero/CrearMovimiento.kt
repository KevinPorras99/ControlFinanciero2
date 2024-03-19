package cr.ac.una.controlfinanciero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cr.ac.una.controlfinanciero.entity.Movimiento
import java.util.Date
import android.content.Intent
import android.app.Activity

class CrearMovimiento : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_movimiento)
        var movimiento = Movimiento(1.1,1, Date())
        var intent = Intent()
        intent.putExtra("resultado",movimiento)
        setResult(Activity.RESULT_OK,intent)
        finish()


    }
}