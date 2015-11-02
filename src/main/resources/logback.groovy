/*
 * Copyright (c) 2015.
 * By Alekum, ASTEC Corporation. All Rights Reserved.
 *
 * jDotlib
 * Created by alekum on 22.10.15 18:33.
 */
import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.classic.filter.LevelFilter
import ch.qos.logback.classic.html.HTMLLayout
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.FileAppender
import ch.qos.logback.core.encoder.LayoutWrappingEncoder
import ch.qos.logback.core.status.OnConsoleStatusListener

import static ch.qos.logback.classic.Level.DEBUG
import static ch.qos.logback.classic.Level.INFO
import static ch.qos.logback.core.spi.FilterReply.ACCEPT
import static ch.qos.logback.core.spi.FilterReply.DENY


statusListener(OnConsoleStatusListener)

def logPath = "logs/"

appender("CONSOLE", ConsoleAppender) {
    filter(LevelFilter){
        level = INFO
        onMatch = DENY
        onMismatch = ACCEPT
    }

    encoder(PatternLayoutEncoder){
        pattern = "Console Appender : %d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n"
    }
}

appender("FILE", FileAppender){
    filter(LevelFilter){
        level = INFO
        onMatch = ACCEPT
        onMismatch = DENY
    }

    file = logPath + "log.file"
    append = false
    encoder(PatternLayoutEncoder){
        outputPatternAsHeader = true
        pattern = "File Appender : %d{HH:mm:ss} [%thread] %-5level %logger{36} -%msg%n"
    }
}

appender("HTMLFile", FileAppender){
    filter(LevelFilter){
        level = INFO
        onMatch = ACCEPT
        onMismatch = DENY
    }

    file = logPath + "log.html"
    append = false
    encoder(LayoutWrappingEncoder){
        layout(HTMLLayout){
            pattern = "%-5relative[%thread]%-5level%logger%msg"
        }
    }
}

logger("logging.logback.LoggingLogback", INFO, ["CONSOLE"], false)

root(DEBUG, ["CONSOLE", "FILE", "HTMLFile"])