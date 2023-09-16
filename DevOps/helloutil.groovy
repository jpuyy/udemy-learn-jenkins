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
        def secretDrink = credential("secret_${drinkType}")
        if (secretDrink!=null) {
            // singal quote
            echo 'you have secret code ${secretDrink}'
        }
    }

    echo "This is your order:"
    echo "${order}"
}

return this