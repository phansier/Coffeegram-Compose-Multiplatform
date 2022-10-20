import androidx.compose.ui.window.Application
import kotlinx.cinterop.ObjCObjectBase
import kotlinx.cinterop.autoreleasepool
import kotlinx.cinterop.cstr
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.toCValues
import org.koin.core.context.startKoin
import platform.Foundation.NSStringFromClass
import platform.UIKit.UIApplication
import platform.UIKit.UIApplicationDelegateProtocol
import platform.UIKit.UIApplicationDelegateProtocolMeta
import platform.UIKit.UIApplicationMain
import platform.UIKit.UIResponder
import platform.UIKit.UIResponderMeta
import platform.UIKit.UIScreen
import platform.UIKit.UIWindow
import ru.beryukhov.coffeegram.DefaultPreview
import ru.beryukhov.coffeegram.appModule

fun main() {
    val args = emptyArray<String>()
    memScoped {
        val argc = args.size + 1
        val argv = (arrayOf("skikoApp") + args).map { it.cstr.ptr }.toCValues()
        autoreleasepool {
            UIApplicationMain(argc, argv, null, NSStringFromClass(SkikoAppDelegate))
        }
    }
}

class SkikoAppDelegate : UIResponder, UIApplicationDelegateProtocol {
    private var _window: UIWindow? = null

    private val koinApp = initKoin().koin

    @ObjCObjectBase.OverrideInit
    constructor() : super()

    override fun window() = _window
    override fun setWindow(window: UIWindow?) {
        _window = window
    }

    override fun application(application: UIApplication, didFinishLaunchingWithOptions: Map<Any?, *>?): Boolean {
        window = UIWindow(frame = UIScreen.mainScreen.bounds)
        window!!.rootViewController = Application("Coffeegram") {
            DefaultPreview(koinApp.get())
        }
        window!!.makeKeyAndVisible()
        return true
    }

    companion object : UIResponderMeta(), UIApplicationDelegateProtocolMeta
}

private fun initKoin() =
    startKoin {
        modules(appModule())
    }
