/*Copyright [2018] [Charfaoui Younes]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.*/

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