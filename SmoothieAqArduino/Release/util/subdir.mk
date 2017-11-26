################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../util/Device.cpp \
../util/Doing.cpp \
../util/SmoothieAq.cpp 

LINK_OBJ += \
./util/Device.cpp.o \
./util/Doing.cpp.o \
./util/SmoothieAq.cpp.o 

CPP_DEPS += \
.\util\Device.cpp.d \
.\util\Doing.cpp.d \
.\util\SmoothieAq.cpp.d 


# Each subdirectory must supply rules for building sources it contributes
util/Device.cpp.o: ../util/Device.cpp
	@echo 'Building file: $<'
	@echo 'Starting C++ compile'
	"C:\Users\jesper\eclipse\java-latest-released\eclipse\/arduinoPlugin/packages/arduino/tools/avr-gcc/4.9.2-atmel3.5.4-arduino2/bin/avr-g++" -c -g -Os -Wall -Wextra -std=gnu++11 -fpermissive -fno-exceptions -ffunction-sections -fdata-sections -fno-threadsafe-statics -flto -mmcu=atmega32u4 -DF_CPU=16000000L -DARDUINO=10609 -DARDUINO_AVR_MICRO -DARDUINO_ARCH_AVR -DUSB_VID=0x2341 -DUSB_PID=0x8037 "-DUSB_MANUFACTURER=\"Unknown\"" "-DUSB_PRODUCT=\"Arduino Micro\""  -I"C:\Users\jesper\eclipse\java-latest-released\eclipse\arduinoPlugin\packages\arduino\hardware\avr\1.6.18\cores\arduino" -I"C:\Users\jesper\eclipse\java-latest-released\eclipse\arduinoPlugin\packages\arduino\hardware\avr\1.6.18\variants\micro" -I"C:\Users\jesper\eclipse\java-latest-released\eclipse\arduinoPlugin\libraries\CmdMessenger\4.0.0" -I"C:\Users\jesper\eclipse\java-latest-released\eclipse\arduinoPlugin\libraries\CmdMessenger\4.0.0\utility" -I"C:\Users\jesper\eclipse\java-latest-released\eclipse\arduinoPlugin\libraries\TimerOne\1.1.0" -I"D:\eclipse-ws\test-ws\SmoothieAqArduino\util" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 -x c++ "$<"  -o  "$@"
	@echo 'Finished building: $<'
	@echo ' '

util/Doing.cpp.o: ../util/Doing.cpp
	@echo 'Building file: $<'
	@echo 'Starting C++ compile'
	"C:\Users\jesper\eclipse\java-latest-released\eclipse\/arduinoPlugin/packages/arduino/tools/avr-gcc/4.9.2-atmel3.5.4-arduino2/bin/avr-g++" -c -g -Os -Wall -Wextra -std=gnu++11 -fpermissive -fno-exceptions -ffunction-sections -fdata-sections -fno-threadsafe-statics -flto -mmcu=atmega32u4 -DF_CPU=16000000L -DARDUINO=10609 -DARDUINO_AVR_MICRO -DARDUINO_ARCH_AVR -DUSB_VID=0x2341 -DUSB_PID=0x8037 "-DUSB_MANUFACTURER=\"Unknown\"" "-DUSB_PRODUCT=\"Arduino Micro\""  -I"C:\Users\jesper\eclipse\java-latest-released\eclipse\arduinoPlugin\packages\arduino\hardware\avr\1.6.18\cores\arduino" -I"C:\Users\jesper\eclipse\java-latest-released\eclipse\arduinoPlugin\packages\arduino\hardware\avr\1.6.18\variants\micro" -I"C:\Users\jesper\eclipse\java-latest-released\eclipse\arduinoPlugin\libraries\CmdMessenger\4.0.0" -I"C:\Users\jesper\eclipse\java-latest-released\eclipse\arduinoPlugin\libraries\CmdMessenger\4.0.0\utility" -I"C:\Users\jesper\eclipse\java-latest-released\eclipse\arduinoPlugin\libraries\TimerOne\1.1.0" -I"D:\eclipse-ws\test-ws\SmoothieAqArduino\util" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 -x c++ "$<"  -o  "$@"
	@echo 'Finished building: $<'
	@echo ' '

util/SmoothieAq.cpp.o: ../util/SmoothieAq.cpp
	@echo 'Building file: $<'
	@echo 'Starting C++ compile'
	"C:\Users\jesper\eclipse\java-latest-released\eclipse\/arduinoPlugin/packages/arduino/tools/avr-gcc/4.9.2-atmel3.5.4-arduino2/bin/avr-g++" -c -g -Os -Wall -Wextra -std=gnu++11 -fpermissive -fno-exceptions -ffunction-sections -fdata-sections -fno-threadsafe-statics -flto -mmcu=atmega32u4 -DF_CPU=16000000L -DARDUINO=10609 -DARDUINO_AVR_MICRO -DARDUINO_ARCH_AVR -DUSB_VID=0x2341 -DUSB_PID=0x8037 "-DUSB_MANUFACTURER=\"Unknown\"" "-DUSB_PRODUCT=\"Arduino Micro\""  -I"C:\Users\jesper\eclipse\java-latest-released\eclipse\arduinoPlugin\packages\arduino\hardware\avr\1.6.18\cores\arduino" -I"C:\Users\jesper\eclipse\java-latest-released\eclipse\arduinoPlugin\packages\arduino\hardware\avr\1.6.18\variants\micro" -I"C:\Users\jesper\eclipse\java-latest-released\eclipse\arduinoPlugin\libraries\CmdMessenger\4.0.0" -I"C:\Users\jesper\eclipse\java-latest-released\eclipse\arduinoPlugin\libraries\CmdMessenger\4.0.0\utility" -I"C:\Users\jesper\eclipse\java-latest-released\eclipse\arduinoPlugin\libraries\TimerOne\1.1.0" -I"D:\eclipse-ws\test-ws\SmoothieAqArduino\util" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 -x c++ "$<"  -o  "$@"
	@echo 'Finished building: $<'
	@echo ' '


