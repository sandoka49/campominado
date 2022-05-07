package view

import model.Campo
import java.awt.event.MouseEvent
import java.awt.event.MouseListener

class MouseCliqueListener(
    private val campo: Campo,
    private val OnBotaoEsquerdo: (Campo) -> Unit,
    private val OnBotaoDireito: (Campo) -> Unit
) : MouseListener {
    override fun mousePressed(e: MouseEvent?) {
        when (e?.button) {
            MouseEvent.BUTTON1 -> OnBotaoEsquerdo(campo)
            MouseEvent.BUTTON3 -> OnBotaoDireito(campo) //ou BUTTON2
        }
    }

    override fun mouseClicked(e: MouseEvent?) {}
    override fun mouseEntered(e: MouseEvent?) {}
    override fun mouseExited(e: MouseEvent?) {}
    override fun mouseReleased(e: MouseEvent?) {}
}
