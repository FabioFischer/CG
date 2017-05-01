package UI;

import java.awt.BorderLayout;

import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/*
**   FURB - Bacharelado em Ciências da Computação
**   Computação Gráfica
**   Unidade 02 - Atividade 04
**
**   Fábio Luiz Fischer & Matheus Navarro Nienow
 */

public class Frame extends JFrame {

    private static final long serialVersionUID = 1L;
    private Main renderer = new Main();

    private int janelaLargura = 400, janelaAltura = 400;

    public Frame() {
        // Cria o frame.
        super("CG-N2-A4");
        setBounds(300, 250, janelaLargura, janelaAltura + 22);  // 400 + 22 da borda do titulo da janela
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        /* Cria um objeto GLCapabilities para especificar 
		 * o numero de bits por pixel para RGBA
      0   */
        GLCapabilities glCaps = new GLCapabilities();
        glCaps.setRedBits(8);
        glCaps.setBlueBits(8);
        glCaps.setGreenBits(8);
        glCaps.setAlphaBits(8);

        /* Cria um canvas, adiciona ao frame e objeto "ouvinte" 
		 * para os eventos Gl, de mouse e teclado
         */
        GLCanvas canvas = new GLCanvas(glCaps);
        this.add(canvas, BorderLayout.CENTER);
        canvas.addGLEventListener(renderer);
        canvas.addKeyListener(renderer);
        canvas.addMouseListener(renderer);
        canvas.addMouseMotionListener(renderer);
        canvas.addMouseWheelListener(renderer);
        canvas.requestFocus();
    }

    public static void main(String[] args) {
        new Frame().setVisible(true);
    }

}
