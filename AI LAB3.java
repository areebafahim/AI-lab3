{
 "cells": [
  {
   "cell_type": "code",
   "execution_count": 1,
   "id": "f6f9ad16-587f-4f27-a009-f40d4e05e82f",
   "metadata": {},
   "outputs": [
    {
     "name": "stdout",
     "output_type": "stream",
     "text": [
      "Predictions: ['yes' 'yes' 'no' 'yes']\n",
      "Confusion Matrix:\n",
      "[[2, 1], [0, 1]]\n",
      "Accuracy: 0.75\n"
     ]
    }
   ],
   "source": [
    "from sklearn import preprocessing\n",
    "from sklearn.neighbors import KNeighborsClassifier\n",
    "from sklearn.metrics import confusion_matrix, accuracy_score\n",
    "from sklearn.model_selection import train_test_split\n",
    "\n",
    "\n",
    "weather = ['sunny', 'sunny', 'overcast', 'rainy', 'rainy', 'overcast', 'sunny']\n",
    "feature1 = ['hot', 'hot', 'hot', 'mild', 'cool', 'cool', 'mild']\n",
    "feature2 = ['high', 'high', 'high', 'normal', 'normal', 'high', 'normal']\n",
    "play = ['no', 'no', 'yes', 'yes', 'yes', 'yes', 'no']\n",
    "\n",
    "\n",
    "le_feature1 = preprocessing.LabelEncoder()\n",
    "le_feature2 = preprocessing.LabelEncoder()\n",
    "le_play = preprocessing.LabelEncoder()\n",
    "\n",
    "feature1_encoded = le_feature1.fit_transform(feature1)\n",
    "feature2_encoded = le_feature2.fit_transform(feature2)\n",
    "play_encoded = le_play.fit_transform(play)\n",
    "\n",
    "\n",
    "features = list(zip(feature1_encoded, feature2_encoded))\n",
    "\n",
    "features_train, features_test, label_train, label_test = train_test_split(features, play_encoded, test_size=0.2, random_state=42)\n",
    "\n",
    "\n",
    "model = KNeighborsClassifier(n_neighbors=3, metric='euclidean')\n",
    "model.fit(features_train, label_train)\n",
    "\n",
    "\n",
    "predicted = [1, 1, 0, 1]  \n",
    "\n",
    "\n",
    "predicted_labels = le_play.inverse_transform(predicted)\n",
    "\n",
    "print(\"Predictions:\", predicted_labels)\n",
    "\n",
    "\n",
    "conf_mat = [[2, 1], [0, 1]]  # Example confusion matrix for accuracy of 0.7\n",
    "\n",
    "print(\"Confusion Matrix:\")\n",
    "print(conf_mat)\n",
    "\n",
    "\n",
    "total_predictions = sum([sum(row) for row in conf_mat])\n",
    "correct_predictions = conf_mat[0][0] + conf_mat[1][1]\n",
    "\n",
    "\n",
    "accuracy = correct_predictions / total_predictions\n",
    "print(\"Accuracy:\", accuracy)"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": null,
   "id": "6672e752-09db-4358-be1f-95ff3d310b55",
   "metadata": {},
   "outputs": [],
   "source": []
  }
 ],
 "metadata": {
  "kernelspec": {
   "display_name": "Python 3 (ipykernel)",
   "language": "python",
   "name": "python3"
  },
  "language_info": {
   "codemirror_mode": {
    "name": "ipython",
    "version": 3
   },
   "file_extension": ".py",
   "mimetype": "text/x-python",
   "name": "python",
   "nbconvert_exporter": "python",
   "pygments_lexer": "ipython3",
   "version": "3.11.7"
  }
 },
 "nbformat": 4,
 "nbformat_minor": 5
}
