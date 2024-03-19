package cr.ac.una.controlfinanciero.entity
import java.util.Date
import java.io.Serializable
data class Movimiento(var monto : Double, var tipo :Int, var fecha: Date) : Serializable
