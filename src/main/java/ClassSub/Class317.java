package ClassSub;

import org.lwjgl.opengl.*;
import org.lwjgl.*;

public class Class317 extends Class225
{
    private Pbuffer pbuffer;
    private Class220 image;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class317(final Class220 image) throws Class341 {
        super(image.getTexture().getTextureWidth(), image.getTexture().getTextureHeight());
        this.image = image;
        Class301.debug("Creating pbuffer(unique) " + image.getWidth() + "x" + image.getHeight());
        if ((Pbuffer.getCapabilities() & 0x1) == 0x0) {
            throw new Class341("Your OpenGL card does not support PBuffers and hence can't handle the dynamic images required for this application.");
        }
        this.init();
    }
    
    private void init() throws Class341 {
        try {
            final Class282 texture = Class144.get().createTexture(this.image.getWidth(), this.image.getHeight(), this.image.getFilter());
            (this.pbuffer = new Pbuffer(this.screenWidth, this.screenHeight, new PixelFormat(8, 0, 0), (RenderTexture)null, (Drawable)null)).makeCurrent();
            this.initGL();
            this.image.draw(0.0f, 0.0f);
            GL11.glBindTexture(3553, texture.getTextureID());
            GL11.glCopyTexImage2D(3553, 0, 6408, 0, 0, texture.getTextureWidth(), texture.getTextureHeight(), 0);
            this.image.setTexture(texture);
            Display.makeCurrent();
        }
        catch (Exception ex) {
            Class301.error(ex);
            throw new Class341("Failed to create PBuffer for dynamic image. OpenGL driver failure?");
        }
    }
    
    @Override
    protected void disable() {
        GL11.glBindTexture(3553, this.image.getTexture().getTextureID());
        GL11.glCopyTexImage2D(3553, 0, 6408, 0, 0, this.image.getTexture().getTextureWidth(), this.image.getTexture().getTextureHeight(), 0);
        try {
            Display.makeCurrent();
        }
        catch (LWJGLException ex) {
            Class301.error((Throwable)ex);
        }
        Class126.leaveSafeBlock();
    }
    
    @Override
    protected void enable() {
        Class126.enterSafeBlock();
        try {
            if (this.pbuffer.isBufferLost()) {
                this.pbuffer.destroy();
                this.init();
            }
            this.pbuffer.makeCurrent();
        }
        catch (Exception ex) {
            Class301.error("Failed to recreate the PBuffer");
            Class301.error(ex);
            throw new RuntimeException(ex);
        }
        Class237.unbind();
        this.initGL();
    }
    
    protected void initGL() {
        GL11.glEnable(3553);
        GL11.glShadeModel(7425);
        GL11.glDisable(2929);
        GL11.glDisable(2896);
        GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GL11.glClearDepth(1.0);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glViewport(0, 0, this.screenWidth, this.screenHeight);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        this.enterOrtho();
    }
    
    protected void enterOrtho() {
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0, (double)this.screenWidth, 0.0, (double)this.screenHeight, 1.0, -1.0);
        GL11.glMatrixMode(5888);
    }
    
    @Override
    public void destroy() {
        super.destroy();
        this.pbuffer.destroy();
    }
    
    @Override
    public void flush() {
        super.flush();
        this.image.flushPixelData();
    }
}
