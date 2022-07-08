package kr.young.common

import android.content.Context
import java.io.*

class FileUtil {
    companion object {
        private const val TAG = "FileUtil"

        @JvmStatic
        fun getFileList(path: String) {
            val dir = File(path)
            for (fileName in dir.list()!!) {
                UtilLog.i(TAG, fileName)
            }
        }

        @JvmStatic
        fun readFile(file: File) {
            try {
                val fileReader = FileReader(file)
                val bufferedReader = BufferedReader(fileReader)
                var line = bufferedReader.readLine()
                while (line != null) {
                    println(line)
                    line = bufferedReader.readLine()
                }
                bufferedReader.close()
                fileReader.close()
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        @JvmStatic
        fun copy(inputStream: InputStream, outputStream: OutputStream) {
            inputStream.use {
                outputStream.use {
                    val buf = ByteArray(1024)
                    var len: Int
                    while (inputStream.read(buf).also { len = it } > 0) {
                        outputStream.write(buf, 0, len)
                    }
                }
            }
        }

        @Throws(IOException::class)
        @JvmStatic
        fun copy(src: File?, dst: File?) {
            val inputStream: InputStream = FileInputStream(src)
            val outputStream: OutputStream = FileOutputStream(dst)
            copy(inputStream, outputStream)
        }

        @JvmStatic
        fun copyAssets(context: Context, fileName: String) {
            val assetManager = context.assets

            val list = assetManager.list("")
            if (list!!.isEmpty()) {
                UtilLog.i(TAG, "asset list is empty")
            }

            val filePath = context.filesDir.path + File.separator + fileName

            val inputStream = assetManager.open(fileName)
            val outputStream = FileOutputStream(filePath)
            copy(inputStream, outputStream)
        }
    }
}