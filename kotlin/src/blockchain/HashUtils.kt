package blockchain

import java.security.MessageDigest

class HashUtils {

    companion object {
        fun hash(something : Block): String {
            val bytes = something.toStringBlock().toByteArray()
            val md = MessageDigest.getInstance("SHA-256")
            val digest = md.digest(bytes)
            return digest.fold("", { str, it -> str + "%02x".format(it) })
        }

        fun hash(something : String): String {
            val bytes = something.toString().toByteArray()
            val md = MessageDigest.getInstance("SHA-256")
            val digest = md.digest(bytes)
            return digest.fold("", { str, it -> str + "%02x".format(it) })
        }
    }

}

