/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.rohitverma882.fastboot.transport

internal interface Transport {
    var isConnected: Boolean
    fun connect(force: Boolean)
    fun disconnect()
    fun close()
    fun send(buffer: ByteArray, timeout: Int)
    fun receive(buffer: ByteArray, timeout: Int)
}