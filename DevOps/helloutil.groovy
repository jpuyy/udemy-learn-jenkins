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

        def withSecretDrink=""
        // test withCredentials
        withCredentials([string(credentialsId: "secret_${drinkType}", variable: 'withSecretDrink')]) {
            echo 'you have secret code ${withSecretDrink}'
        }
        echo 'try wider variable ${withSecretDrink}'
        sh 'echo "try wider variable ${withSecretDrink}"'
        sh "echo try wider variable ${withSecretDrink}"
    }

    echo "This is your order:"
    echo "${order}"
}

return this