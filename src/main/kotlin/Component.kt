interface Component {
    val name: String

    fun add(component: Component)
    fun remove(component: Component)
    fun inflate()
}

class Leaf(override val name: String) : Component {
    override fun add(component: Component) {}

    override fun remove(component: Component) {}

    override fun inflate() {
        println(name)
    }
}

class Composite(override val name: String) : Component {
    private val components = mutableListOf<Component>()

    override fun add(component: Component) {
        components.add(component)
    }

    override fun remove(component: Component) {
        components.remove(component)
    }

    override fun inflate() {
        println(name)
        components.forEach {
            it.inflate()
        }
    }
}

fun main() {
    val leaf1 = Leaf("Leaf1")
    val leaf2 = Leaf("Leaf2")
    val leaf3= Leaf("Leaf3")
    val leaf4 = Leaf("Leaf4")
    val composite1 = Composite("Composite1")
    val composite2 = Composite("Composite2")
    val composite3 = Composite("Composite3")
    val composite4 = Composite("Composite4")

    composite1.add(leaf1)
    composite1.add(leaf2)
    composite1.inflate()
    println("=========")

    composite2.add(leaf1)
    composite2.add(leaf2)
    composite2.add(leaf3)
    composite2.remove(leaf2)
    composite2.inflate()
    println("=========")

    composite3.add(leaf1)
    composite3.add(leaf2)

    composite4.add(leaf3)
    composite4.add(leaf4)
    composite4.add(composite3)
    composite4.inflate()
}