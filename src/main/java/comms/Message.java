/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comms;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 */
public class Message {

    private String nickname;
    private String content;

    public Message(String nickname, String content) {
        this.nickname = nickname;
        this.content = content;

    }

    public Message(String jsonString) throws ParseException {
        JSONObject jsonObject = new JSONObject();
        JSONParser parser = new JSONParser();
        Object parsedObject = parser.parse(jsonString);
        jsonObject = (JSONObject) parsedObject;
        //parsedObject.
        this.nickname = jsonObject.get("nickname").toString();
        this.content = jsonObject.get("content").toString();
    }

    public String toJSONString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("nickname", getNickname());
        jsonObject.put("content", getContent());
        return jsonObject.toJSONString();
    }

    /**
     * @return the nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname the nickname to set
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return new String(nickname + ": " + content);
    }

}
