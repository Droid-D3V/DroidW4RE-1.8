package net.ccbluex.liquidbounce.ui.icon

import net.ccbluex.liquidbounce.LiquidBounce
import net.ccbluex.liquidbounce.utils.MinecraftInstance
import net.ccbluex.liquidbounce.utils.misc.RandomUtils
import net.minecraft.client.renderer.texture.DynamicTexture
import net.minecraft.util.ResourceLocation
import java.awt.image.BufferedImage
import javax.imageio.ImageIO

class IconManager : MinecraftInstance() {
    companion object {
        private val icons=HashMap<String,ResourceLocation>()

        @JvmStatic
        fun loadIcons() {
            loadIcon("check-circle")
            loadIcon("close-circle")
            loadIcon("information")
        }

        private fun loadIcon(name: String){
            icons[name] = genResource(ImageIO.read(IconManager.javaClass.classLoader.getResourceAsStream("icon/$name.png")))
        }

        fun getIcon(name: String): ResourceLocation? {
            return icons[name]
        }

        fun genResource(image: BufferedImage?): ResourceLocation {
            //create and load
            val resourceLocation = ResourceLocation(
                LiquidBounce.CLIENT_NAME.toLowerCase()+"/"
                        + RandomUtils.randomString(10)
            )
            mc.textureManager.loadTexture(resourceLocation, DynamicTexture(image))
            return resourceLocation
        }
    }
}