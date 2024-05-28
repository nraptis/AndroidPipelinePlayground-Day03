package com.example.droidrenderdemoearth

import android.content.Context
import java.nio.IntBuffer
import javax.microedition.khronos.egl.EGLConfig

class EarthScene(
    override var width: Int,
    override var height: Int,
    override var context: Context?,
    override var activity: GraphicsActivity?) : GraphicsScene {

    override var graphicsPipeline: GraphicsPipeline? = null
    override var graphics: GraphicsLibrary? = null

    val earthMap = GraphicsTexture()
    val testTexture = GraphicsTexture()





    var blahInstane = GraphicsSprite2DInstance()
    var davidBlane = GraphicsSprite3DInstance()
    var tomRizzo = GraphicsSpriteBlurInstance()
    var geraldoHanjab = GraphicsSpriteBlurInstance()

    var blahInstane2 = GraphicsSprite2DInstance()
    var davidBlane2 = GraphicsSprite3DInstance()
    var tomRizzo2 = GraphicsSpriteBlurInstance()
    var geraldoHanjab2 = GraphicsSpriteBlurInstance()






    override fun initialize(config: EGLConfig) {
        println("EarthScene => initialize")


    }

    override fun load() {
        println("EarthScene => load")


        earthMap.load(context, graphics, "earth_texture.jpg")
        testTexture.load(context, graphics, "test.png")




        blahInstane.load(graphics, earthMap)
        blahInstane.projectionMatrix.ortho(width, height)

        davidBlane.load(graphics, earthMap)
        davidBlane.projectionMatrix.ortho(width, height)

        tomRizzo.load(graphics, testTexture)
        tomRizzo.projectionMatrix.ortho(width, height)

        geraldoHanjab.load(graphics, testTexture)
        geraldoHanjab.projectionMatrix.ortho(width, height)




        blahInstane2.load(graphics, earthMap)
        blahInstane2.projectionMatrix.ortho(width, height)

        davidBlane2.load(graphics, earthMap)
        davidBlane2.projectionMatrix.ortho(width, height)

        tomRizzo2.load(graphics, testTexture)
        tomRizzo2.projectionMatrix.ortho(width, height)

        geraldoHanjab2.load(graphics, testTexture)
        geraldoHanjab2.projectionMatrix.ortho(width, height)




    }


    override fun loadComplete() {
        println("EarthScene => loadComplete")

    }

    override fun update(deltaTime: Float) {
        //println("EarthScene => update ( " + deltaTime + " )")

    }

    //fun
    override fun draw3DPrebloom(width: Int, height: Int) {

    }
    override fun draw3DBloom(width: Int, height: Int) {

    }

    override fun draw3DStereoscopicLeft(width: Int, height: Int) {

    }
    override fun draw3DStereoscopicRight(width: Int, height: Int) {

    }

    var svn = 0.0f

    override fun draw3D(width: Int, height: Int) {

        svn += 0.01f
        if (svn > (2.0f * 3.14f)) {
            svn -= 2.0f * 3.14f
        }



        blahInstane.setPositionFrame(-512.0f, -512.0f, 1024.0f, 1024.0f)
        blahInstane.modelViewMatrix.translation(width / 4.0f, height * 3.0f / 4.0f, 0.0f)
        blahInstane.modelViewMatrix.rotateZ(-svn)
        blahInstane.modelViewMatrix.scale(0.5f)

        blahInstane.render(graphicsPipeline?.programSprite2D)

        davidBlane.setPositionFrame(-512.0f, -512.0f, 1024.0f, 1024.0f)
        davidBlane.modelViewMatrix.translation(width / 4.0f, height / 4.0f, 0.0f)
        davidBlane.modelViewMatrix.rotateZ(svn)
        davidBlane.modelViewMatrix.scale(0.5f)

        davidBlane.render(graphicsPipeline?.programSprite3D)


        tomRizzo.setPositionFrame(-512.0f, -512.0f, 1024.0f, 1024.0f)
        tomRizzo.modelViewMatrix.translation(width * 3.0f / 4.0f, height * 3.0f / 4.0f, 0.0f)
        tomRizzo.modelViewMatrix.rotateZ(svn)
        tomRizzo.modelViewMatrix.scale(0.5f)

        tomRizzo.render(graphicsPipeline?.programBlurHorizontal)


        geraldoHanjab.setPositionFrame(-512.0f, -512.0f, 1024.0f, 1024.0f)
        geraldoHanjab.modelViewMatrix.translation(width * 3.0f / 4.0f, height / 4.0f, 0.0f)
        geraldoHanjab.modelViewMatrix.rotateZ(svn)
        geraldoHanjab.modelViewMatrix.scale(0.5f)

        geraldoHanjab.render(graphicsPipeline?.programBlurVertical)


    }
    override fun draw2D(width: Int, height: Int) {


        blahInstane2.setPositionFrame(-512.0f, -512.0f, 1024.0f, 1024.0f)
        blahInstane2.modelViewMatrix.translation(width / 4.0f, height * 3.0f / 4.0f + 100.0f, 0.0f)
        blahInstane2.modelViewMatrix.rotateZ(svn)
        blahInstane2.modelViewMatrix.scale(0.75f)

        blahInstane2.render(graphicsPipeline?.programSprite2D)

        davidBlane2.setPositionFrame(-512.0f, -512.0f, 1024.0f, 1024.0f)
        davidBlane2.modelViewMatrix.translation(width / 4.0f, height / 4.0f + 100.0f, 0.0f)
        davidBlane2.modelViewMatrix.rotateZ(-svn)
        davidBlane2.modelViewMatrix.scale(0.75f)

        davidBlane2.render(graphicsPipeline?.programSprite3D)


        tomRizzo2.setPositionFrame(-512.0f, -512.0f, 1024.0f, 1024.0f)
        tomRizzo2.modelViewMatrix.translation(width * 3.0f / 4.0f, height * 3.0f / 4.0f + 100.0f, 0.0f)
        tomRizzo2.modelViewMatrix.rotateZ(-svn)
        tomRizzo2.modelViewMatrix.scale(0.75f)
        tomRizzo2.render(graphicsPipeline?.programBlurHorizontal)


        geraldoHanjab2.setPositionFrame(-512.0f, -512.0f, 1024.0f, 1024.0f)
        geraldoHanjab2.modelViewMatrix.translation(width * 3.0f / 4.0f, height / 4.0f + 100.0f, 0.0f)
        geraldoHanjab2.modelViewMatrix.rotateZ(-svn)
        geraldoHanjab2.modelViewMatrix.scale(0.75f)
        geraldoHanjab2.render(graphicsPipeline?.programBlurVertical)

    }

}