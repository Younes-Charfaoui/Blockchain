package library

import org.json.JSONObject

interface Data {

    fun toJSONObject() : JSONObject
}