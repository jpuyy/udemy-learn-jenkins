def createLunch(Map params = [:]) {
    def lunch = params.get("lunch")
    def price = params.get("price")

    def drinkType = params.get('drink', null)

    def order = """[
        {
            "price": ${price},
            "lunch": ${lunch}
        }
    ]"""

    if (drinkType!=null) {
        order = """[
            {
                "price": ${price},
                "lunch": ${lunch},
                "drink": ${drinkType}
            }
        ]"""

        def withSecretDrink="111"
        // test withCredentials
        withCredentials([string(credentialsId: "secret_${drinkType}", variable: 'withSecretDrink')]) {
            echo '1 you have secret code ${withSecretDrink}'
            echo "2 you have secret code '${withSecretDrink}'"
            writeFile(file: "filename.txt", text: "try wider variable ${withSecretDrink}", encoding: "UTF-8")
            println(withSecretDrink.length())
            sh "echo ${withSecretDrink} | wc -c"
        }
        echo '3 try wider variable ${withSecretDrink}'
        sh 'echo "4 try wider variable ${withSecretDrink}"'
        sh "echo 5 try wider variable ${withSecretDrink}"
    }

    echo "This is your order:"
    echo "${order}"
}

return this