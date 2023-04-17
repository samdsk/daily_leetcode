-spec kids_with_candies(Candies :: [integer()], ExtraCandies :: integer()) -> [boolean()].
kids_with_candies(Candies, ExtraCandies) ->
    Max = lists:max(Candies) - ExtraCandies,
    lists:map(fun(C)-> C>=Max end,Candies)
.