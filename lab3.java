{
 "cells": [
  {
   "cell_type": "code",
   "execution_count": 1,
   "id": "0a4e47eb-1481-41ce-a5b6-327280b1ec87",
   "metadata": {},
   "outputs": [
    {
     "name": "stdout",
     "output_type": "stream",
     "text": [
      "Prediction: ['yes' 'yes']\n",
      "Confusion Matrix:\n",
      "[[0 2]\n",
      " [0 0]]\n",
      "Accuracy: 0.0\n"
     ]
    }
   ],
   "source": [
    "from sklearn import preprocessing\n",
    "from sklearn.neighbors import KNeighborsClassifier\n",
    "from sklearn.metrics import confusion_matrix, accuracy_score\n",
    "from sklearn.model_selection import train_test_split\n",
    "\n",
    "weather = ['sunny', 'sunny', 'overcast', 'rainy', 'rainy', 'overcast', 'sunny']\n",
    "feature1 = ['hot', 'hot', 'hot', 'mild', 'cool', 'cool', 'mild']\n",
    "feature2 = ['high', 'high', 'high', 'normal', 'normal', 'high', 'normal']\n",
    "play = ['no', 'no', 'yes', 'yes', 'yes', 'yes', 'no']\n",
    "\n",
    "le_weather = preprocessing.LabelEncoder()\n",
    "le_feature1 = preprocessing.LabelEncoder()\n",
    "le_feature2 = preprocessing.LabelEncoder()\n",
    "le_play = preprocessing.LabelEncoder()\n",
    "\n",
    "weather_encoded = le_weather.fit_transform(weather)\n",
    "feature1_encoded = le_feature1.fit_transform(feature1)\n",
    "feature2_encoded = le_feature2.fit_transform(feature2)\n",
    "play_encoded = le_play.fit_transform(play)\n",
    "features = list(zip(feature1_encoded, feature2_encoded))\n",
    "\n",
    "features_train, features_test, label_train, label_test = train_test_split(features, play_encoded, test_size=0.2, random_state=42)\n",
    "\n",
    "model = KNeighborsClassifier(n_neighbors=3, metric='euclidean')\n",
    "model.fit(features_train, label_train)\n",
    "\n",
    "predicted = model.predict(features_test)\n",
    "\n",
    "predicted_labels = le_play.inverse_transform(predicted)\n",
    "\n",
    "print(\"Prediction:\", predicted_labels)\n",
    "conf_mat = confusion_matrix(label_test, predicted)\n",
    "\n",
    "print(\"Confusion Matrix:\")\n",
    "print(conf_mat)\n",
    "\n",
    "accuracy = accuracy_score(label_test, predicte111d)\n",
    "print(\"Accuracy:\", accuracy)"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": null,
   "id": "4d42cf23-3706-49c9-8c06-c7a74c142beb",
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
