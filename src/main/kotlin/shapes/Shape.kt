package shapes

import java.awt.Graphics

interface Shape {
    fun draw(graphics: Graphics)
    fun mutate()
}