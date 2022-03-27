import android.content.Context
import android.content.SharedPreferences
import com.gulshan.sirfstudymessanger.util.Keys.Companion.PREFERENCE_AUTH_KEY

object SharedPref {
    private const val NAME = "sirfstudyPreferences"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    private val IS_FIRST_RUN_PREF = Pair("is_first_run", false)

    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    /**
     * SharedPreferences extension function, so we won't need to call edit() and apply()
     * ourselves on every SharedPreferences operation.
     */

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var firstRun: Boolean
        get() = preferences.getBoolean(IS_FIRST_RUN_PREF.first, IS_FIRST_RUN_PREF.second)
        set(value) = preferences.edit() {
            it.putBoolean(IS_FIRST_RUN_PREF.first, value)
        }

    fun writeString(key: String, value: String) {
        preferences.edit() {
            it.putString(key, value)
        }
    }

    fun getString(key: String): String? {
        return preferences.getString(key, "")
    }

    fun putInt(key: String, value: Int) {
        preferences.edit() {
            it.putInt(key, value)
        }
    }

    fun getInt(key: String): Int {
        return preferences.getInt(key, -1)
    }

    fun getAccessToken(): String? {
        return preferences.getString(PREFERENCE_AUTH_KEY, "")
    }


}