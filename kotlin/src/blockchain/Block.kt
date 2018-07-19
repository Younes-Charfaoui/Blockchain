package blockchain

import org.json.JSONObject

class Block(val number : Long, val nonce : Long, val data: String
            , val previousHash : String ) {


    val hash : String
    get() = HashUtils.hash(this)

    fun hash() : String{
        return HashUtils.hash(this)
    }


    override fun toString(): String {
        val blockObject = JSONObject()
        blockObject.put("number",number)
                .put("nonce" , nonce)
                .put("data",data)
                .put("previousHash" , previousHash)
                .put("Hash", hash)
        return blockObject.toString()
    }

    fun toStringBlock(): String {
        val blockObject = JSONObject()
        blockObject.put("number",number)
                .put("nonce" , nonce)
                .put("data",data)
                .put("previousHash" , previousHash)
        return blockObject.toString()
    }
}