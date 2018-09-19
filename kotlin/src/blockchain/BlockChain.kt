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

import org.json.JSONArray
import org.json.JSONObject

class BlockChain {

    val chain = mutableListOf<Block>()

    constructor()  {
        chain.add(Block(1, 128, "First blockchain.Block", "0000"))
    }

    constructor(blockchain: String){
        val jsonObject = JSONObject(blockchain)
        val blocksArray = jsonObject.getJSONArray("blocks")
        for(i in 0..blocksArray.length()){
            val number = blocksArray.getJSONObject(i).getLong("number")
            val data = blocksArray.getJSONObject(i).getString("data")
            val previousHash = blocksArray.getJSONObject(i).getString("previousHash")
            val hash = blocksArray.getJSONObject(i).getString("hash")
            val nonce = blocksArray.getJSONObject(i).getLong("nonce")
            //chain.add(Block(number,nonce,data,previousHash,hash))
        }
    }

    private fun getLastBlock(): Block = chain[chain.size - 1]

    fun mineBlock(data : String) : Block {
        var nonce = 1
        var check = false
        val lastBlock = getLastBlock()
        val jsonObject = JSONObject()
        jsonObject.put("number" , lastBlock.number + 1)
        jsonObject.put("data" , data)
        jsonObject.put("previousHash" , lastBlock.hash())
        while (!check ){
            val hash = HashUtils.hash(jsonObject.put("nonce", nonce).toString())
            if (hash.get(0) == '0')
                check = true
            else
                nonce++
        }
        val newBlock = Block(lastBlock.number + 1, nonce.toLong(), data, lastBlock.hash())
        chain.add(newBlock)
        return newBlock
    }

    override fun toString(): String {
        val blockChainObject = JSONObject()
        val blocksArray = JSONArray()
        for (block in chain) {
            blocksArray.put(JSONObject(block.toString()))
        }
        blockChainObject.put("blocks" , blocksArray)
        blockChainObject.put("length" , chain.size)
        blockChainObject.put("isValid" , this.isValid())
        return blockChainObject.toString()
    }

    fun isValid() : Boolean {
        var previous = chain[0]
        var currentIndex = 1
        while (currentIndex < chain.size){
            val block = chain[currentIndex]
            if (!block.previousHash.equals(previous.hash)) return false
            if (block.hash[0] != '0') return false
            previous = block
            currentIndex++
        }
        return true
    }
}