# EmbedSocialInternshipExcercise
I only displayed 5 attributes of the json data in the final table with the reasoning that it is enough to show that the filtering and sorting works.
I displayed the review ID, reviewer name, review rating, review text and the date the review was created on.
From the testing i did on the application the data is filtered and sorted as intented.
Except when the reviews are sorted by text priority.
When sorted by text priority the filter doesn't take into account the order rating.
This ussue could probably be fixed by splitting the list into two different lists, one that contains text, other that doesn't and sorting them from there.
