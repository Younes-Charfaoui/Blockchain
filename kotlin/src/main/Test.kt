package main

import blockchain.BlockChain

fun main(args: Array<String>) {
    val blockChain2 = "{\"blocks\":[{\"number\":1,\"data\":\"First blockchain.Block\",\"previousHash\":\"0000\",\"Hash\":\"35d4c4b1d88a6913f731d09b7f39dda2781a3a49dee57b64a3eae0dfe85f5492\",\"nonce\":128},{\"number\":2,\"data\":\"Younes had 50\$\",\"previousHash\":\"35d4c4b1d88a6913f731d09b7f39dda2781a3a49dee57b64a3eae0dfe85f5492\",\"Hash\":\"04e5239f77caa985554cfe7904864ba543d1513da16ba494abdb9166f3305704\",\"nonce\":1},{\"number\":3,\"data\":\"Latif have 200\$\",\"previousHash\":\"04e5239f77caa985554cfe7904864ba543d1513da16ba494abdb9166f3305704\",\"Hash\":\"0feb3846cc95333c222cacb64821bf139627f1257e65174c4ca4e3c9e5cf7079\",\"nonce\":80},{\"number\":4,\"data\":\"Younes Gain 1000\$\",\"previousHash\":\"0feb3846cc95333c222cacb64821bf139627f1257e65174c4ca4e3c9e5cf7079\",\"Hash\":\"02e6ecabdd5faf5218fc37f2a4984d7847f31bb73ba63bfab0cccecfb5921429\",\"nonce\":34},{\"number\":5,\"data\":\"Lina Get 100\$ From Younes\",\"previousHash\":\"02e6ecabdd5faf5218fc37f2a4984d7847f31bb73ba63bfab0cccecfb5921429\",\"Hash\":\"0b048d00c854c792b1e0a00b35146203c672e106a90cfb7df716abc490989ccb\",\"nonce\":28}],\"isValid\":true,\"length\":5}\n"
    val blockChain = BlockChain(blockChain2)
    println(blockChain.isValid())
}