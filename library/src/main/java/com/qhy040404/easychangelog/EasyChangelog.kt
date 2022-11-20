package com.qhy040404.easychangelog

/**
 * @param delimiter Delimiter between versions, e.g. "v", "---"
 */
@Suppress("unused")
class EasyChangelog(private val delimiter: String) {
    /**
     * @param fullLog Full Changelog
     * @param version Version String
     * @return current version's Changelog
     */
    fun parse(fullLog: String, version: String): List<String> {
        val finalLogs = mutableListOf<String>()

        val cut = fullLog.substringAfter(version).substringBefore(delimiter).trim()
        cut.split("\n").forEach {
            finalLogs.add(it.trim().extractItem())
        }

        return finalLogs
    }

    private fun String.extractItem(): String {
        return if (this.startsWith("-") || this.startsWith("*")) this.substring(2)
        else this
    }
}