
package br.furb.main.frame;

public class FrameController {
    
    private FrameListener frameListener;
    private Renderer renderer;
    private int appMode;

    private static final int STAND_BY_MODE = 1;
    private static final int NEW_OBJECT_MODE = 2;
    private static final int SEL_OBJECT_MODE = 3;
    private static final int UPD_OBJECT_MODE = 4;
    
    public FrameController() {        
        this.setAppMode(this.STAND_BY_MODE);
        this.setRenderer(new Renderer());
        this.setFrameListener(new FrameListener(this));
    }
    
    public int getAppMode() {
        return appMode;
    }

    public void setAppMode(int appMode) {
        this.appMode = appMode;
    }

    public FrameListener getFrameListener() {
        return frameListener;
    }

    public void setFrameListener(FrameListener frameListener) {
        this.frameListener = frameListener;
    }

    public Renderer getRenderer() {
        return renderer;
    }

    public void setRenderer(Renderer renderer) {
        this.renderer = renderer;
    }
}
