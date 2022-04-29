package view

import model.Tabuleiro
import model.TabuleiroEvento
import javax.swing.JFrame
import javax.swing.JOptionPane
import javax.swing.SwingUtilities

 fun main(args: Array<String>){
    TelaPrincipal()
}

    class TelaPrincipal : JFrame() {
        private val tabuleiro = Tabuleiro(qtdeLinhas = 16, qtdeColunas = 30, qtdeMinas = 60)
        private val painelTabuleiro = PainelTabuleiro(tabuleiro)

        init {
            tabuleiro.onEvento ( this::mostraResultado )
            add(painelTabuleiro)
            setSize(690, 438)
            setLocationRelativeTo(null)
            defaultCloseOperation = EXIT_ON_CLOSE
            title = "Campo Minado"
            isVisible = true
        }

        private fun mostraResultado (evento: TabuleiroEvento){
            SwingUtilities.invokeLater{
                val msg = when(evento){
                    TabuleiroEvento.VITORIA -> "Você Ganhou"
                    TabuleiroEvento.DERROTA -> "Você Perdeu ....:P"
                }
                JOptionPane.showMessageDialog(this,msg)
                tabuleiro.reiniciar()

                painelTabuleiro.repaint()
                painelTabuleiro.validate()
            }
        }
    }

