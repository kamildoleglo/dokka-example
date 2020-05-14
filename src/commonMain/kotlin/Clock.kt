package example

/**
 * Documentation for expected class Clock
 * in common module
 * Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam et tincidunt felis.
 * Proin consectetur in lacus nec congue. Ut vulputate odio in tellus iaculis bibendum.
 * Proin condimentum velit vitae nisl gravida, sit amet elementum leo tincidunt.
 * Quisque volutpat mollis sapien, eget bibendum nisi aliquam non.
 * Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.
 * Quisque pharetra purus in magna lobortis feugiat. Nulla vel commodo felis.
 * Interdum et malesuada fames ac ante ipsum primis in faucibus.
 * Donec ante tellus, egestas vel massa ac, tempor gravida sapien. Aliquam sed dignissim lacus.
 * Mauris dictum bibendum felis, non condimentum lectus. Fusce et fringilla arcu. Sed condimentum vitae nisi nec tempus.
 * Quisque viverra sapien elit, non luctus eros viverra sit amet.
 * Nulla lacus lectus, pretium mattis lacinia at, gravida vitae erat. Donec vitae gravida metus, vel iaculis dolor.
 * Etiam sit amet risus non ex accumsan tempus eu vitae enim.
 * Curabitur nec tempus quam. Vivamus quis dui eu metus luctus consequat at sit amet eros.
 * Nam hendrerit justo commodo, maximus ligula vel, fermentum tellus. Aliquam at efficitur odio, eu volutpat est.
 * Fusce nec maximus ex. Phasellus suscipit sit amet neque a vulputate.
 *
 * Morbi nec diam pellentesque, volutpat tellus lobortis, aliquet orci.
 * Etiam eu nisi vel enim porta tincidunt quis eu ligula. Ut mauris nulla, laoreet nec erat nec, finibus consequat massa.
 * Pellentesque quis mauris facilisis, malesuada ipsum nec, dictum mauris. Mauris semper purus a odio bibendum malesuada.
 * Nullam finibus, nunc vitae egestas placerat, nibh mi luctus justo, vel efficitur lacus augue ut purus.
 * Maecenas feugiat convallis orci a suscipit. Pellentesque eu nunc eu orci iaculis fermentum.
 * Sed porta odio ut justo molestie aliquet at quis magna.
 * @param first tag
 * @param second tag
 */
expect open class Clock() {
    val x: String
    fun getTime(): String
    /**
     * Time in minis
     */
    fun String.tst(): String
    fun getTimesInMillis(): String
    fun getYear(): String
}

expect interface ClockInterface

expect enum class ClockEnum

expect object ClockObject

expect fun spanishInquisition()

expect annotation class A