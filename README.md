# Ctrl-Yourself

Ctrl-Yourself is a small local area network (LAN) game for developers in the form of a chat room.

Recall those long nights in the office working late? Boring right? 
Ctrl-Yourself tries to make coding more fun by challenging users everytime they do a combination of keys (e.g. Ctrl+C). 
When this happens, the user that pressed the keys (user X) is presented with a full screen pop-up with a challenge and a funny sound clip. 
All other connected users will receive a notification in the chat stating that X pressed a combination of keys and the respective challenge.
They will then have to certify that user X does the challenge.

Procrastinators can also use the chat to communicate!

## Challenges

Challenges are small tasks that have to be performed in the real life. These will be accompanied by a funny sound clip at all times.

Example of a challenge:
Title - Fantasia
Description - Go grab a broom and do your best tango.

Check all the challenges here: https://github.com/bluetrickpt/Ctrl-Yourself/blob/master/src/main/java/com/whatthehack/ctrl/yourself/game/Challenge.java

## Key combinations

We tried to cover the most commonly used key combinations, specially amongst programmers:
* Alt-Tab
* Ctrl+A
* Ctrl+F
* Ctrl+T
* Ctrl+C
* Ctrl+V
* Ctrl+Z
* Ctrl+S
* Ctrl+X
* Ctrl+Y
* Ctrl+Alt+F1-12
* Ctrl+Shift+N
* Ctrl+Shift+P
* Ctrl+Shift+T
* Ctrl+Shift+Z

Full list: https://github.com/bluetrickpt/Ctrl-Yourself/blob/master/src/main/java/com/whatthehack/ctrl/yourself/helpers/KeyboardHandler.java

## FAQ

#### Is this a keylogger?

Absolutely not! We do have key handlers that are called when certain combination of keys are pressed. We do not log any key stroke.

#### Will this project be continued?

Not in a foreseeable future. 

#### Where did you have this idea?

Ctrl-Yourself was born in a 48h hackathon (ShiftAPPens 2017 - https://shiftappens.com/). We didn't win, but it was quite fun to participate.

## Contributors

* Bruna Nogueira
* Filipe Lopes
* Pedro Girão
* Ricardo Mendes
