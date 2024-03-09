import pandas as pd
import matplotlib.pyplot as plt

# Load the CSV file
df = pd.read_csv('RR1_BestFitness_Tournament_Comparision.csv')

# Set the 'Generation' column as the X-axis
x = df['Generation']

# Plotting each line
plt.plot(x, df['RR1 T Size = 3'], label='RR1 T Size = 3')
plt.plot(x, df['RR1 T Size = 5'], label='RR1 T Size = 5')
plt.plot(x, df['RR1 T Size = 7'], label='RR1 T Size = 7')

# Adding title and labels
plt.title('RR1 - Time to Best Fitness Comparision')
plt.xlabel('Generation')
plt.ylabel('Best Fitness')

# Adding a legend
plt.legend()

# Display the plot
plt.show()
