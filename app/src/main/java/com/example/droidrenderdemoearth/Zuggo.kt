package com.example.droidrenderdemoearth

import java.nio.IntBuffer

class Zuggo(graphicsPipeline: GraphicsPipeline?,
            texture: GraphicsTexture?,
            graphics: GraphicsLibrary?) {

    val zuggoVertz = arrayOf(
        VertexSprite2D(-256.0f, -256.0f, 0.0f, 0.0f),
        VertexSprite2D(256.0f, -256.0f, 1.0f, 0.0f),
        VertexSprite2D(-256.0f, 256.0f, 0.0f, 1.0f),
        VertexSprite2D(256.0f, 256.0f, 1.0f, 1.0f)
    )

    val indices = intArrayOf(0, 1, 2, 3)
    val indexBuffer: IntBuffer

    var color = Color(1.0f, 1.0f, 1.0f, 1.0f)

    var projectionMatrix = Matrix()
    var modelViewMatrix = Matrix()

    val graphics: GraphicsLibrary?
    val graphicsPipeline: GraphicsPipeline?
    val texture: GraphicsTexture?

    private var svn = 0.0f

    val vertexBuffer: GraphicsArrayBuffer<VertexSprite2D>

    init {

        this.graphics = graphics
        this.graphicsPipeline = graphicsPipeline
        this.texture = texture

        vertexBuffer = GraphicsArrayBuffer(graphics, zuggoVertz)

        projectionMatrix.ortho(graphics?.widthf ?: 0.0f,
            graphics?.heightf ?: 0.0f)
        indexBuffer = graphics?.indexBufferGenerate(indices) ?: IntBuffer.allocate(0)

    }

    var spin = 0.0f
    fun draw() {
        // Add program to OpenGL ES environment
        val piFloat: Float = kotlin.math.PI.toFloat()

        svn += 0.01f
        if (svn > (2.0f * piFloat)) {
            svn -= 2.0f * piFloat
        }

        spin += 0.005f
        if (spin > (2.0f * piFloat)) {
            spin -= 2.0f * piFloat
        }

        color.blue = 0.5f + svn * 0.2f
        color.red = 0.5f + spin * 0.2f

        val width = graphics?.widthf ?: 0.0f
        val height = graphics?.heightf ?: 0.0f


        modelViewMatrix.translation(width / 2.0f, height / 2.0f, 0.0f)
        modelViewMatrix.rotateZ(spin)
        modelViewMatrix.scale(1.5f)

        graphics?.blendSetAlpha()

        graphics?.linkBufferToShaderProgram(graphicsPipeline?.programBlurHorizontal, vertexBuffer)

        graphics?.uniformsTextureSet(graphicsPipeline?.programBlurHorizontal, texture)
        graphics?.uniformsModulateColorSet(graphicsPipeline?.programBlurHorizontal, color)
        graphics?.uniformsProjectionMatrixSet(graphicsPipeline?.programBlurHorizontal, projectionMatrix)
        graphics?.uniformsModelViewMatrixSet(graphicsPipeline?.programBlurHorizontal, modelViewMatrix)

        graphics?.drawTriangleStrips(indexBuffer, 4)
        graphics?.unlinkBufferFromShaderProgram (graphicsPipeline?.programBlurHorizontal)
    }

}


