
package Main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Frame extends JFrame implements ActionListener{
    
    private Renderer renderer  = new Renderer();

    public Frame() {
        super("CG-N3");
        setBounds(100, 350, 600 + 16, 600 + 39); 
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                
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
        canvas.requestFocus();}
    
    public static void main(String[] args) {
        new Frame().setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}
