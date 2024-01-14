# Fastboot Android

Android library for sending fastboot commands from an Android device to a device running fastboot.

***Only supports fastboot over USB On-The-Go (OTG) connections.***


## Usage
### List Attached Fastboot Devices
```kotlin
// Includes connected devices.
val deviceIds : List<DeviceId> = FastbootDeviceManager.getAttachedDeviceIds()
```

### List Connected Fastboot Devices
```kotlin
val deviceIds : List<DeviceId> = FastbootDeviceManager.getConnectedDeviceIds()
```

### Connect to a Fastboot Device
```kotlin
// typealias DeviceId = String
FastbootDeviceManager.addFastbootDeviceManagerListener(
    object : FastbootDeviceManagerListener() {
        override fun onFastbootDeviceAttached(deviceId: DeviceId) {
            Log.d("Device attached: $deviceId")
        }

        override fun onFastbootDeviceDetached(deviceId: DeviceId) {
            Log.d("Device detached: $deviceId")
        }

        override fun onFastbootDeviceConnected(deviceId: DeviceId, deviceContext: FastbootDeviceContext) {
            // Do some fastboot stuff...
            val response = deviceContext.sendCommand(FastbootCommand.getVar("current-slot"))
            val bootSlot = response.data
            Log.d("Device $deviceId with slot $bootSlot.")
        }
    })

FastbootDeviceManager.connectToDevice(/* Device Name */ "/dev/bus/usb/001/002")
```
