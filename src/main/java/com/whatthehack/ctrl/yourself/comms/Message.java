/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.whatthehack.ctrl.yourself.comms;

import com.whatthehack.ctrl.yourself.game.GameManager;
import java.util.ArrayList;
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
    private int code;

    //TODO: Implement codes
    public static final int SYSTEM_MESSAGE = 1;
    public static final int USER_MESSAGE = 2;
    public static final int CHALLENGE_MESSAGE = 3;
    public static final int NEW_MEMBER_MESSAGE = 4;
    public static final int UPDATE_USER_LIST_MESSAGE = 5;
    public static final int SERVER_CLOSING_MESSAGE = 6;
    public static final int USER_LEAVING_MESSAGE = 7;

    public static final String USERS_DELIMITER = "&&";

    private static final String SYSTEM_FONT_SIZE = "20";
    private static final String USER_FONT_SIZE = "16";

    public Message(String nickname, String content, int code) {
        this.nickname = nickname;
        this.content = content;
        this.code = code;
    }

    public Message(String jsonString) throws ParseException {
        JSONObject jsonObject = new JSONObject();
        JSONParser parser = new JSONParser();
        Object parsedObject = parser.parse(jsonString);
        jsonObject = (JSONObject) parsedObject;
        //parsedObject.
        this.nickname = jsonObject.get("nickname").toString();
        this.content = jsonObject.get("content").toString();
        //System.out.println(jsonObject.toString());
        this.code = Integer.parseInt(jsonObject.get("code").toString());
    }

    public String toJSONString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("nickname", getNickname());
        jsonObject.put("content", getContent());
        jsonObject.put("code", getCode());
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
        return (nickname + ": " + content + " (" + code + ")");
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

    static String handleNewMessage(Message receivedMessage, GameManager gameManager) {
        String result = new String();
        switch (receivedMessage.getCode()) {
            case NEW_MEMBER_MESSAGE:
                gameManager.addUser(receivedMessage.getNickname());
            //No break, since NEW_MEMBER_MESSAGE is also a SYSTEM_MESSAGE
            case SYSTEM_MESSAGE:
                result = "<html><b><span style=\"font-size:" + SYSTEM_FONT_SIZE + ";\">*** " + receivedMessage.getContent() + " ***</span></b></html>";
                break;
            case USER_MESSAGE:
                result = "<html><b><span style=\"font-size:" + USER_FONT_SIZE + ";\">" + receivedMessage.getNickname() + ": " + receivedMessage.getContent() + "</span></b></html>";

                break;
            case CHALLENGE_MESSAGE:
                result = "<html><b><span style=\"color:red; font-size:" + USER_FONT_SIZE + ";\">Heads up! " + receivedMessage.getContent() + "</span></b></html>";
                break;
            case UPDATE_USER_LIST_MESSAGE:
                initUsersFromString(receivedMessage.getContent(), gameManager);
                break;
            case SERVER_CLOSING_MESSAGE:
                //TODO
                gameManager.disableMessages();
                break;
            case USER_LEAVING_MESSAGE:
                result = "<html><b><span style=\"font-size:" + SYSTEM_FONT_SIZE + ";\">*** " + clientLeavingString(receivedMessage.getNickname()) + " ***</span></b></html>";
                System.out.println(result);
                break;
            default:
                throw new RuntimeException("Invalid entry");
        }
        return result;
    }

    public static String getWelcomeString(String nickname) {
        return (nickname + " joined the chat");
    }

    public static String serverClosingString() {
        return "Server shutting down. You will be disconnected";
    }

    public static String clientLeavingString(String nick) {
        return "User " + nick + " left";
    }

    public static void initUsersFromString(String jsonArrayUsers, GameManager gameManager) {
        //System.out.print("initializing: " + jsonArrayUsers);
        gameManager.restartUsers();
        String[] users = jsonArrayUsers.split(USERS_DELIMITER);
        for (int i = 0; i < users.length; ++i) {
            gameManager.addUser(users[i]);
        }
    }
}
