
package br.furb.main.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/*
**   FURB - Bacharelado em Ciências da Computação
**   Computação Gráfica
**   Unidade 03
**
**   Fábio Luiz Fischer & Matheus Navarro Nienow
 */

public class Frame extends JFrame implements ActionListener{
    
    private Renderer renderer  = new Renderer();

    public Frame() {
        super("CG-N3");
        setBounds(80, 80, 600 + 16, 600 + 39);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                
        getContentPane().setLayout(new BorderLayout());
        
        GLCapabilities glCaps = new GLCapabilities();
        glCaps.setRedBits(8);
        glCaps.setBlueBits(8);
        glCaps.setGreenBits(8);
        glCaps.setAlphaBits(8);

        GLCanvas canvas = new GLCanvas(glCaps);
        this.add(canvas, BorderLayout.CENTER);
        canvas.addGLEventListener(renderer);
        canvas.addKeyListener(renderer);
        canvas.addMouseListener(renderer);
        canvas.addMouseMotionListener(renderer);
        canvas.addMouseWheelListener(renderer);
        canvas.requestFocus();}
    
    public static void main(String[] args) {
        new Frame().setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    }    
}
