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
        // define credential secret_finta in jenkins
        def secretDrink = credentials("secret_${drinkType}")
        if (secretDrink!=null) {
            // singal quote
            echo 'you have secret code ${secretDrink}'
        }

        // test withCredentials
        withCredentials([string(credentialsId: "secret_${drinkType}", variable: 'withSecretDrink')]) {
            echo 'you have secret code ${withSecretDrink}'
        }
        echo 'try wider variable ${withSecretDrink}'
    }

    echo "This is your order:"
    echo "${order}"
}

return this