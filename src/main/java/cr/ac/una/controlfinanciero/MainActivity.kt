package cr.ac.una.controlfinanciero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cr.ac.una.controlfinanciero.controller.MovimientoController
import cr.ac.una.controlfinanciero.adapter.MovimientoAdapter
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import android.widget.Button
import cr.ac.una.controlfinanciero.entity.Movimiento
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    var movimientoController: MovimientoController = MovimientoController()
    lateinit var adapter: MovimientoAdapter
    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonNuevo = findViewById<Button>(R.id.botonNuevo)
        botonNuevo.setOnClickListener {
           insertEntity()
        }


        activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == RESULT_OK){
                val data: Intent? = it.data
                if(data != null){
                    movimientoController.insertMovimiento(data.getSerializableExtra("resultado") as Movimiento)
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }
    private fun insertEntity(){
        val intent = Intent(this, CrearMovimiento::class.java)
        activityResultLauncher.launch(intent)
    }



}