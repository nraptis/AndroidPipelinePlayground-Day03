package com.example.droidrenderdemoearth

import android.content.Context
import android.graphics.Bitmap

class GraphicsTexture {

    var graphics: GraphicsLibrary?
    var textureIndex: Int
    var width: Int
    var widthf: Float

    var height: Int
    var heightf: Float


    var fileName: String?

    constructor(context: Context?, graphics: GraphicsLibrary?, fileName: String) : this(graphics,
        FileUtils.readFileFromAssetAsBitmap(context, fileName), fileName) {

    }

    constructor(graphics: GraphicsLibrary?, bitmap: Bitmap?, fileName: String? = null) {
        this.graphics = graphics
        this.fileName = fileName

        width = 0
        height = 0
        widthf = 0.0f
        heightf = 0.0f

        textureIndex = -1

        graphics?.let { _graphics ->
            bitmap?.let { _bitmap ->
                width = _bitmap.width
                height = _bitmap.height
                widthf = width.toFloat()
                heightf = height.toFloat()
                textureIndex = _graphics.textureGenerate(_bitmap)
            }
        }
    }

    constructor(graphics: GraphicsLibrary?, width: Int, height: Int, fileName: String? = null) {
        this.graphics = graphics
        this.fileName = fileName
        this.width = width
        this.height = height
        this.widthf = width.toFloat()
        this.heightf = height.toFloat()

        textureIndex = -1

        graphics?.let { _graphics ->
            textureIndex = _graphics.textureGenerate(width, height)
        }
    }

}