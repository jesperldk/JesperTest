################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
C:/Users/jesper/eclipse/java-latest-released/eclipse/arduinoPlugin/libraries/CmdMessenger/4.0.0/utility/DoEvery.cpp \
C:/Users/jesper/eclipse/java-latest-released/eclipse/arduinoPlugin/libraries/CmdMessenger/4.0.0/utility/HeaterSim.cpp 

LINK_OBJ += \
./libraries/CmdMessenger/utility/DoEvery.cpp.o \
./libraries/CmdMessenger/utility/HeaterSim.cpp.o 

CPP_DEPS += \
.\libraries\CmdMessenger\utility\DoEvery.cpp.d \
.\libraries\CmdMessenger\utility\HeaterSim.cpp.d 


# Each subdirectory must supply rules for building sources it contributes
libraries/CmdMessenger/utility/DoEvery.cpp.o: C:/Users/jesper/eclipse/java-latest-released/eclipse/arduinoPlugin/libraries/CmdMessenger/4.0.0/utility/DoEvery.cpp
	@echo 'Building file: $<'
	@echo 'Starting C++ compile'
	"C:\Users\jesper\eclipse\java-latest-released\eclipse\/arduinoPlugin/packages/arduino/tools/avr-gcc/4.9.2-atmel3.5.4-arduino2/bin/avr-g++" -c -g -Os -Wall -Wextra -std=gnu++11 -fpermissive -fno-exceptions -ffunction-sections -fdata-sections -fno-threadsafe-statics -flto -mmcu=atmega32u4 -DF_CPU=16000000L -DARDUINO=10609 -DARDUINO_AVR_MICRO -DARDUINO_ARCH_AVR -DUSB_VID=0x2341 -DUSB_PID=0x8037 "-DUSB_MANUFACTURER=\"Unknown\"" "-DUSB_PRODUCT=\"Arduino Micro\""  -I"C:\Users\jesper\eclipse\java-latest-released\eclipse\arduinoPlugin\packages\arduino\hardware\avr\1.6.18\cores\arduino" -I"C:\Users\jesper\eclipse\java-latest-released\eclipse\arduinoPlugin\packages\arduino\hardware\avr\1.6.18\variants\micro" -I"C:\Users\jesper\eclipse\java-latest-released\eclipse\arduinoPlugin\libraries\CmdMessenger\4.0.0" -I"C:\Users\jesper\eclipse\java-latest-released\eclipse\arduinoPlugin\libraries\CmdMessenger\4.0.0\utility" -I"C:\Users\jesper\eclipse\java-latest-released\eclipse\arduinoPlugin\libraries\TimerOne\1.1.0" -I"D:\eclipse-ws\test-ws\SmoothieAqArduino\util" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 -x c++ "$<"  -o  "$@"
	@echo 'Finished building: $<'
	@echo ' '

libraries/CmdMessenger/utility/HeaterSim.cpp.o: C:/Users/jesper/eclipse/java-latest-released/eclipse/arduinoPlugin/libraries/CmdMessenger/4.0.0/utility/HeaterSim.cpp
	@echo 'Building file: $<'
	@echo 'Starting C++ compile'
	"C:\Users\jesper\eclipse\java-latest-released\eclipse\/arduinoPlugin/packages/arduino/tools/avr-gcc/4.9.2-atmel3.5.4-arduino2/bin/avr-g++" -c -g -Os -Wall -Wextra -std=gnu++11 -fpermissive -fno-exceptions -ffunction-sections -fdata-sections -fno-threadsafe-statics -flto -mmcu=atmega32u4 -DF_CPU=16000000L -DARDUINO=10609 -DARDUINO_AVR_MICRO -DARDUINO_ARCH_AVR -DUSB_VID=0x2341 -DUSB_PID=0x8037 "-DUSB_MANUFACTURER=\"Unknown\"" "-DUSB_PRODUCT=\"Arduino Micro\""  -I"C:\Users\jesper\eclipse\java-latest-released\eclipse\arduinoPlugin\packages\arduino\hardware\avr\1.6.18\cores\arduino" -I"C:\Users\jesper\eclipse\java-latest-released\eclipse\arduinoPlugin\packages\arduino\hardware\avr\1.6.18\variants\micro" -I"C:\Users\jesper\eclipse\java-latest-released\eclipse\arduinoPlugin\libraries\CmdMessenger\4.0.0" -I"C:\Users\jesper\eclipse\java-latest-released\eclipse\arduinoPlugin\libraries\CmdMessenger\4.0.0\utility" -I"C:\Users\jesper\eclipse\java-latest-released\eclipse\arduinoPlugin\libraries\TimerOne\1.1.0" -I"D:\eclipse-ws\test-ws\SmoothieAqArduino\util" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 -x c++ "$<"  -o  "$@"
	@echo 'Finished building: $<'
	@echo ' '


