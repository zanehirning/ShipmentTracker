import java.io.FileReader

class CsvParser(
    private val path: String
) {
    private var currentLineIndex = 0
    private val reader: FileReader = FileReader(path)
    private val lines: List<String> = reader.readLines()

   private fun readNextLine(): String {
        if (hasNextLine()) {
            var line = lines[currentLineIndex]
            currentLineIndex++
            println(currentLineIndex)
            return line
        }
        reader.close()
        return ""
    }

    fun hasNextLine(): Boolean {
        return currentLineIndex < lines.size
    }

    fun parseLine(): List<String> {
        return readNextLine().split(",")
    }
}