package UI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/*
**   FURB - Bacharelado em Ciências da Computação
**   Computação Gráfica
**   Unidade 02 - Atividade 07
**
**   Fábio Luiz Fischer & Matheus Navarro Nienow
 */

public class Frame extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private Main renderer = new Main();

    private int janelaLargura = 400, janelaAltura = 400;

    public Frame() {
        // Cria o frame.
        super("CG-N2-A7");
        setBounds(300, 250, janelaLargura, janelaAltura + 22);  // 400 + 22 da borda do titulo da janela
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        JButton b1 = new JButton("Teste");
        b1.addActionListener(this);
        
        getContentPane().setLayout(new BorderLayout());
        
        /* Cria um objeto GLCapabilities para especificar 
		 * o numero de bits por pixel para RGBA
        */
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

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
