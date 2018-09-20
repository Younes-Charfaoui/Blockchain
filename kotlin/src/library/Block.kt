package library

import org.json.JSONObject

abstract class Block(private val number: Long,
                     private val nonce: Int,
                     private val data: Data,
                     private val timestamp: Long,
                     private val previousHash: String) {

    fun toStringBlock(): String {
        return JSONObject()
                .put("number", number)
                .put("nonce", nonce)
                .put("data", data.toJSONObject().toString())
                .put("previousHash", previousHash)
                .put("timestamp", timestamp)
                .toString()
    }
}