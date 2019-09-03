package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var countPosMatch = 0       // right position
    var countLetterMatch = 0   // wrong position
    val AStr: String
    val BStr: String
    if (secret.equals(guess)) return Evaluation(secret.length,0)
    if (secret.length > guess.length) {
        AStr = guess ; BStr = secret
    } else {
        BStr = guess ; AStr = secret
    }

    for (i in 0..AStr.length-1) {
        if (AStr.get(i).compareTo(BStr.get(i)) == 0) {
            countPosMatch++
        } else if (BStr.contains(AStr.get(i))) {
            countLetterMatch++
        }
    }
    return Evaluation(countPosMatch, countLetterMatch)
}