def createLunch(Map params = [:]) {
    def lunch = params.get("lunch")
    def price = params.get("price")

    String drinkType = params.get('drink', null)

    switch(drinkType) {
        case "cococola":
            def order = """[
                {
                    "price": ${price},
                    "lunch": ${lunch},
                    "drink": ${drinkType}

                }
            ]"""
        default:
            def order = """[
                {
                    "price": ${price},
                    "lunch": ${lunch}
                }
            ]"""
    }

    echo "This is your order:"
    echo "${order}"
}

return this