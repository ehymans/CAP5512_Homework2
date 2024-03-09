import pandas as pd
import matplotlib.pyplot as plt

# Load the CSV file
df = pd.read_csv('RR2_Tournament_7.csv')

# Set the 'Generation' column as the X-axis
x = df['Generation']

# Plotting each line
plt.plot(x, df['Average Fitness'], label='Average Fitness')
plt.plot(x, df['Best Fitness'], label='Best Fitness')
plt.plot(x, df['Standard Deviation'], label='Standard Deviation')
plt.plot(x, df['Average Hamming Distance'], label='Average Hamming Distance')

# Adding title and labels
plt.title('RR2 Stats for Tournament Size 7')
plt.xlabel('Generation')
plt.ylabel('Fitness / StdDev / Hamming Distance')

# Adding a legend
plt.legend()

# Display the plot
plt.show()
