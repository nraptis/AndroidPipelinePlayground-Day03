package com.example.droidrenderdemoearth

class Earth(var graphics: GraphicsLibrary?,
            var graphicsPipeline: GraphicsPipeline?) {

    var earthModelData: EarthModelData
    var earthModelDataStrips: Array<EarthModelDataStrip>

    init {
        //this.graphics = graphics
        //this.graphicsPipeline = graphicsPipeline
        earthModelData = EarthModelData(graphics?.widthf ?: 320.0f,graphics?.heightf ?: 320.0f)
        earthModelDataStrips = Array<EarthModelDataStrip>(EarthModelData.tileCountV) {
            EarthModelDataStrip(earthModelData, it + 1, graphics, graphicsPipeline)
        }
    }

}